package dragger.bqt.com.dragger;

import android.util.Log;

import javax.inject.Inject;

import dagger.Component;
import dagger.Module;

public class MainPresenter implements IMainPresenter {
	private IMainView mainView;
	private String name;
	@Inject MainModel mainModel;//注意：如果是通过Module中@Provides注解标注的方法来生成对象，这里可以声明为IMainModel
	// 否则，必须声明为MainModel，因为框架是去查MainModel中使用@Inject标注的构造方法，而不是接口中的***
	
	public MainPresenter(IMainView mainView, String name) {
		this.mainView = mainView;
		this.name = name;
		Log.i("bqt", "【构造MainPresenter】");
		DaggerMainModelComponent.builder()
				.mainModelModule(new MainModelModule())
				.build()
				.inject(this);
	}
	
	@Override
	public void login(String password) {
		String info = mainModel.login(name, password);
		if (mainView != null) mainView.showToast(info);
		Log.i("bqt", info);
	}
}

//*******************************************以下是MVP中M相关的类***********************************************
interface IMainModel {
	String login(String name, String password);
}

class MainModel implements IMainModel {
	@Override
	public String login(String name, String password) {
		return (password == null || password.equals("")) ? "请登录" : "登录成功，你的名字为：" + name;
	}
	
	@Inject
	public MainModel() {
		Log.i("bqt", "【构造MainModel】");
	}
}

@Component(modules = MainModelModule.class)
interface MainModelComponent {
	void inject(MainPresenter mainPresenter);
}

@Module
class MainModelModule {
}