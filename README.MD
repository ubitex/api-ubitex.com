域名:  http://api.ubit.site 
现货统一前缀 /v1/spot
合约统一前缀 /v1/future-u

签名: 
1、先通过用户中心申请appkey和secretkey，针对不同的调用，提供不同的appkey和secretkey
2、加入timestamp(时间戳)，其值应当是请求发送时刻的unix时间戳(毫秒)，数据的有郊时间根据此值来计算。
3、加入signature(数据签名)，所有数据的签名信息。
4、加入recvwindow(自定义请求有效时间)，有效时间目前相对简单统一固定为某个值。
服务器收到请求时会判断请求中的时间戳，最长60秒，最小为2秒，如果是5000毫秒之前发出的，则请求会被认为无效。这个时间窗口值可以通过发送可选参数recvWindow来设置。 另外，如果服务器计算得出客户端时间戳在服务器时间的‘未来’一秒以上，也会拒绝请求。 关于交易时效性 互联网状况并不100%可靠，不可完全依赖,因此你的程序本地到UBIT服务器的时延会有抖动. 这是我们设置recvwindow的目的所在，如果你从事高频交易，对交易时效性有较高的要求，可以灵活设置recvwindow以达到你的要求。
不推荐使用5秒以上的recvwindow
5、加入algorithms (签名方法/算法)，用户计算签名是基于哈希的协议，推荐使用HmacSHA256。具体支持那些协议，请参见下面表格中所列出。
HmacMD5、HmacSHA1、HmacSHA224、HmacSHA256(推荐)、HmacSHA384、HmacSHA512
HmacMD5、HmacSHA1、HmacSHA224、HmacSHA256(推荐)、HmacSHA384、HmacSHA512

签名生成
以http://api.ubit.site/v1/spot 为例。
以下是在linux bash环境下使用 echo openssl 和curl工具实现的一个调用接口下单的示例 appkey、secret仅供示范：
appKey: uasdfk-76d0-4f6e-a6b2-asdfdas
secretKey: bc6630d0231fda5cd98794f52c4998659beda290
Header部分数据：
validate-algorithms: HmacSHA256
validate-appkey: uasdfk-76d0-4f6e-a6b2-asdfdas
validate-recvwindow: 5000
validate-timestamp: 1717234493000
validate-signature: 1231312318f13dc27dbbd02c2cc51ff7059765ed12313131

请求数据：
{
  type: 'LIMIT',
  timeInForce: 'GTC',
  side: 'BUY',
  symbol: 'btc_usdt',
  price: '69000',
  quantity: '1'
}

1、数据部分
method: 大写的请求方法，例如：GET、POST、DELETE、PUT
path: 按照path中顺序将所有value进行拼接。形如/test/{var1}/{var2}/的restful路径将按填入的实际参数后路径拼接，示例：/sign/test/bb/aa
query: 按照key的字典序排序，将所有key=value进行拼接。示例：userName=dfdfdf&password=ggg

body:   
    Json: 直接按JSON字符串不做转换或排序操作。

    x-www-form-urlencoded: 按照key的字典序排序，将所有key=value进行拼接，示例:userName=dfdfdf&password=ggg　

    form-data：此格式暂不支持。

如果存在多种数据形式，则按照path、query、body的顺序进行再拼接，得到所有数据的拼接值。

方法method示例：
POST

路径path示例:
/v1/spot/order

上述拼接值记作为path

参数通过query示例:
symbol=btc_usdt

上述值拼接记作query

参数通过body示例：
x-www-form-urlencoded:
  
    symbol=btc_usdt&side=BUY&type=LIMIT&timeInForce=GTC&quantity=1&price=69000

    上述值拼接记作body

json:

    {"symbol":"btc_usdt","side":"BUY","type":"LIMIT","timeInForce":"GTC","quantity":1,"price":69000}

    上述值拼接记作body

# api-ubitex.com
