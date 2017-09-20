package dragger.bqt.com.dragger;

/**
 * 作者：白乾涛 <a href=[http://www.cnblogs.com/baiqiantao] /><p>
 * 创建时间：2017/9/20 13:47 <p>
 * 描述：
 */
public class MainModel implements IMainModel {
	@Override
	public String login(String name, String password) {
		return (password == null || password.equals("")) ? "请登录" : "登录成功，你的名字为：" + name;
	}
}
