package edu.bgcms.config;
import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016092900623469";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCrPjHPYleeVNs9nSrOamYXMNdzdovRha7sASQY3b5zGQfP1wc1ugxjbN0lXLXHdIUx2PJL2m+4fd9FSm7WHXIx47h6P3+CbTz1HEKFwsZGIs0sie2D9lUHxKhfRUnwxoXsNggi4v741tH3M3jjm+6tYb5UuXoYI6hvPnKoWpDMIpZ1s1kdXzNdb2V/adQ02Zfq8KuZgk6LcSF6DaJQrEaqyJ2HrF/BnVnzobVjrht7RT8BY74nGsDr3rVH4fabEsUArytzZbQ3e6R0pIw8XYSAN5tkfg9xQ8HJ+pcTpm2qG+u41tx0wBVcG9KYWhr4FWk/I1Pqrp7+A6tt/JaF+bjVAgMBAAECggEAPWdT3RVabb/nzbQpwVKNwQsWdqSvhjX1f1L5aqE4xXTYRELKpw1Lm+tRcTBJTngNus4cM+7j2Lfp86K5E7YDWLhbUhqq0k3xacL0Z5psFoIsKChdLtCJtPtjlKX32YqWQxks2bWjz/7X01h1pMgpUaqW4TKRAU7n+tvdqViwS0ITTSKe8qSQVo0VmNlP8n56ZdSFD748n6ddJkBDdwBHP+0yHYnW0LhHSy+vogcau9kvjZR/FN4Hmwlzb711sStsr/5l0IDXoPW+DvkbvxXIXPGOBZych/n0rXjqgIcEAGHhTyA95nkG9u9MHokfo5sN9k0YJqiNP8Jlptk3B64ZgQKBgQD5prLriPR/J4j7G7PFCT+jq4OUsPWaEeoqdsYI7pwvOvB+S82qvlSW4FhNYwSr1JxSrLKm+gU2wruRPjS10kyhUINHso/8XYwO2830apyC6PJXFyHiVXgKFnYDNteJC8QG2P2I7u86z02oqqyB5fEQdqxVAyCWkU/iIQVJK1yHeQKBgQCvmQkZNLBj/+VTGYQG79WZCwSRAE4r73CaOaUtrMu+BRT5Kd/K5yUeMgSSS3MMAfMBm84ESyNvTqS0TMWNUONx3fpptpDee3OVBdO7J/ic/cfImnVLmrN7qW9QQ0de5SGgGlpAfqNCWEYA/fYgL/YNu6oJzQKjoiwJV2+tjn+5PQKBgQDR1wpg6/cGwgZjev95yLJTMiEhZDSsUg6PrtH6RAXHtTTcE39F20FiqCPQuD/+5nCXFU39B/5F7xyVksHfamq61N/j7fUU3NSS0LKmlM4FQyQfi/QROGHzqLl9LiWwrdERKGbDKIKw3fqaoQrrDIm5muZzdnN326BXpAW7YNUfkQKBgHfja3PbJmdQCnl/HUZDLzmLbTW22KhklSOnIeCaboyxGY24ikQVJqGEEtzzSHw1RH2fq7wAtRPExO0Y0XRXesJ+hP7yF9zeup5PWS0Z8EL3fhS3aEgTOmG+3/ITzUG7/QY7l80a6UpdzIXW3tlBBaSAsWp5n0ira5eBLA16EjgdAoGAB53JtA+QRmmIqIMgoVTg8mpuGRF+SYLj5KuHgo8JqJMIJCVCdS2Q57718lSUrJquAzOG+VV+voGSZW7got0jSOtDbMi23JaCXFwLdjCa+CX8wedHQDQd3uCs+YYQtmcDfIASjuWLgtntJXkzUgsqXzZNLmak4qWdko3SdTi+Eck=";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAlGrmES2sco3gBCdp6WXHdvDlKzvGMzaunJg5dYeq3pUk7BFJw9oVcJ618I9aYhN4XuWOT+P7BOurjeledMJ7XjrQBvHixETvCBFuvEXbjZSDCbGIt649EM1LBemceN5lEFSbyAjXr5W3e0cB2g0kEMY+b6HK6MB9SHU0wENsIKNQfS3yStdcRkCxWAl4U6o6tLoxya8Tka8AMikykbVW7qjsfI7MsaMlHFWyo6suIHvFaRaPboDh9SklVDeqUxC5/P/fa9JEo1ggU2LIbT81azaypS+pL3cz+OJnGWrhsP1cB+byGmR/MZzWb1BmACXwGGjykd7tr3CDATZ3T3i5DQIDAQAB";
	
    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://bgcms.free.idcfengye.com/notify_url";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://bgcms.free.idcfengye.com/return_url";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	//正式环境
//	public static String gatewayUrl = "https://openapi.alipay.com/gateway.do";
	//沙箱环境
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

