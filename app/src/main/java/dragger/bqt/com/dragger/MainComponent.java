package dragger.bqt.com.dragger;

import dagger.Component;

@PerMainScope
@Component(modules = {MainModule.class, MainPresenterModule.class})
public interface MainComponent {
	void injectToMainActivity(MainActivity activity);//这里必须指定要注入到哪个类里面，参数声明必须是MainActivity而不能是IMainView
	
	void injectToMainPresenter(MainPresenter presenter);
}
