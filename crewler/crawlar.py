# -*- coding: utf-8 -*-
"""
Created on Fri Apr  9 07:37:33 2021

@author: 16150
"""
import requests
from selenium import webdriver
from selenium.webdriver.chrome.options import Options
import time
import os

from bs4 import BeautifulSoup  # 网页解析，获取数据
import re  # 正则表达式，进行文字匹配`
import urllib.request, urllib.error  # 制定URL，获取网页数据


import csv
import codecs
import sys

# Press the green button in the gutter to run the script.
DepartTime= re.compile(r'aria-hidden="true">(.*?)</span>')
Airline= re.compile(r'data-test-id="flight-operated">(.*?) • ')
stopover=re.compile(r'">(.*?)</span')
Price=re.compile(r'uitk-price-a11y is-visually-hidden">(.*?)<')
Type=re.compile(r'class="uitk-heading-7">(.*?)<')
Type2=re.compile(r'aria-hidden="true">(.*?)<')
Weight=re.compile(r'>Included up to (.*?) kg')


def getdata(data,Infor):
    Pri=re.findall(Price,str(Infor))
    data.append(Pri[0])
    T=Infor.find('section',class_="uitk-flex-item")
    Typ=re.findall(Type,str(T))
    if(Typ==[]):
        Typ=re.findall(Type2,str(T))
    data.append(Typ[0])
    Wei=re.findall(Weight,str(Infor))
    Towei=0
    for w in Wei:
        if(int(w)>=16):
            Towei = Towei + int(w)
    data.append(str(Towei))

    return data


def saveData(datas,savepath):
    file_csv = codecs.open(savepath, 'w+', 'utf-8')  # 追加
    writer = csv.writer(file_csv, delimiter=' ', quotechar=' ', quoting=csv.QUOTE_MINIMAL)
    for data in datas:
        writer.writerow(data)
    print("保存文件成功，处理结束")




def get_url_dynamic(url):
    datalist = []
    chrome_options = Options()
    chrome_options.add_argument('--headless')
    chrome_options.add_argument('--disable-gpu')
    driver_path = 'C:/FLY/chromedriver.exe'  # 这里放的就是下载的driver本地路径 ___________________________
    driver = webdriver.Chrome(executable_path=driver_path)
    driver.get(url)
    time.sleep(10)
    a=driver.find_elements_by_css_selector("button[class='uitk-card-link']")
    i=0
    for button in a:
        driver.execute_script("arguments[0].click();", button)
        html = driver.page_source
        soup = BeautifulSoup(html, "html.parser")
        Mult=soup.find_all('div',class_="uitk-flex uitk-flex-column uitk-flex-justify-content-space-between link-container")
        for M in Mult:
            data = []
            T = soup.find('div',
                          class_="uitk-flex uitk-flex-column uitk-flex-gap-one uitk-spacing uitk-spacing-padding-inline-three")
            Tim = re.findall(DepartTime, str(T))
            data.append(Tim[0])
            A = soup.find('div', class_="uitk-text-spacing-one uitk-type-300")
            Airl = re.findall(Airline, str(A))
            data.append(Airl[0])
            Y = T.find_all('span', class_="uitk-type-300 uitk-flex-item uitk-text-emphasis-theme")
            Sto = re.findall(stopover, str(Y))
            for S in Sto:
                data.append(S)
            getdata(data,M)
            datalist.append(data)
        i+=1
        if(i>10):
            break

    return datalist

if __name__ == '__main__':
    savepath = "Tickets.csv"
    baseurl="https://www.expedia.co.uk/Flights-Search?filters=%5B%7B%22preferredAirlineFilterValue%22%3A%7B%22carrierCode%22%3A%22AA%22%7D%7D%2C%7B%22preferredAirlineFilterValue%22%3A%7B%22carrierCode%22%3A%22BA%22%7D%7D%2C%7B%22preferredAirlineFilterValue%22%3A%7B%22carrierCode%22%3A%22CX%22%7D%7D%2C%7B%22preferredAirlineFilterValue%22%3A%7B%22carrierCode%22%3A%22AY%22%7D%7D%2C%7B%22preferredAirlineFilterValue%22%3A%7B%22carrierCode%22%3A%22IB%22%7D%7D%2C%7B%22preferredAirlineFilterValue%22%3A%7B%22carrierCode%22%3A%22JL%22%7D%7D%2C%7B%22preferredAirlineFilterValue%22%3A%7B%22carrierCode%22%3A%22MH%22%7D%7D%2C%7B%22preferredAirlineFilterValue%22%3A%7B%22carrierCode%22%3A%22QF%22%7D%7D%2C%7B%22preferredAirlineFilterValue%22%3A%7B%22carrierCode%22%3A%22QR%22%7D%7D%2C%7B%22preferredAirlineFilterValue%22%3A%7B%22carrierCode%22%3A%22AT%22%7D%7D%2C%7B%22preferredAirlineFilterValue%22%3A%7B%22carrierCode%22%3A%22RJ%22%7D%7D%2C%7B%22preferredAirlineFilterValue%22%3A%7B%22carrierCode%22%3A%22S7%22%7D%7D%2C%7B%22preferredAirlineFilterValue%22%3A%7B%22carrierCode%22%3A%22UL%22%7D%7D%5D&leg1=from%3A"
    #departure = str(input("departure:"))
    departure = sys.argv[1]
    #destination = str(input("destination:"))
    destination = sys.argv[2]
    #Time = str(input("Time:")).split("-")
    Time = sys.argv[3].split("-")
    url=baseurl+departure+"%29%2Cto%3A"+destination+"%29%2Cdeparture%3A"+Time[2]+"%2F"+Time[1]+"%2F"+Time[0]+"TANYT&mode=search&options=carrier%3A%2A%2Ccabinclass%3A%2Cmaxhops%3A1%2Cnopenalty%3AN&passengers=adults%3A1%2Cchildren%3A0%2Cinfantinlap%3AN&sortOrder=INCREASING&sortType=PRICE&trip=oneway"
    datalist = get_url_dynamic(url)

    # saveData(datalist, savepath)
    for context in datalist:
        print(context)


