package dragger.bqt.com.dragger;

import dagger.Component;

@Component(modules = MainModule.class)
public interface MainComponent {
	void inject(MainActivity activity);//这里必须指定要注入到哪个类里面，参数声明必须是MainActivity而不能是IMainView
}
