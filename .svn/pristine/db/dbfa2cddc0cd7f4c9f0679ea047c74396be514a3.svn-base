package ty.cloud.mq.consumer.utils;

import net.sf.json.JSONObject;

public class WeiXinTokenUtil {

	public static String getToken()
	{
		String token = "";
		JsonUrlUtil ju = new JsonUrlUtil();
        ju.setUrl("http://cloud.51tys.com/Wx!getToken.action");
        String jsonUrl = ju.loadJson();
        JSONObject jsonObject = JSONObject.fromObject(jsonUrl);
        token  = jsonObject.getString("data");
        return token;
	}
}
