#字节：通过网络传输信息的单位，一个字节包含8位二进制
#字符：抽象符号，java中使用unicode编码，一个字符占用2个字节，16位二进制
#io 
1、I/O类库中使用流这个抽象概念，代表任何有能力产生数据的数据源对象或有能力接收数据的接收端对象，    流屏蔽了实际的I/O设备中处理数据的细节。
2、任何自InputStream或Reader派生而来的类都含有名为read()的基本方法，用于读取单个字节或字节数      组。
3、任何自OutputStream或Write派生而来的类都含有名为write()的基本方法，用于写单个字节或字节数组。