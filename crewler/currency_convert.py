import json
import ssl
import sys
import urllib.request


def runWeb(from_curr,to_curr):
    host = 'https://jisuhuilv.market.alicloudapi.com'
    path = '/exchange/single'
    method = 'ANY'
    appcode = '0bfab2e455784e46a2904a5c3cb5bb34'
    querys = 'currency=' + from_curr
    bodys = {}
    url = host + path + '?' + querys

    request = urllib.request.Request(url)
    request.add_header('Authorization', 'APPCODE ' + appcode)
    ctx = ssl.create_default_context()
    ctx.check_hostname = False
    ctx.verify_mode = ssl.CERT_NONE
    response = urllib.request.urlopen(request, context=ctx)
    content = response.read()
    t2 = json.loads(content)
    to_list = t2['result']['list']
    print(to_list[to_curr]['rate'])


if __name__ == '__main__':
    from_curr = sys.argv[1]
    to_curr = sys.argv[2]
    print(from_curr +"   "+ to_curr)
    runWeb(from_curr,to_curr)
