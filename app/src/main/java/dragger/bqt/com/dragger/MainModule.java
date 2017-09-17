package dragger.bqt.com.dragger;

import android.util.Log;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {
	private IMainView mainView;
	private String name;
	
	public MainModule(IMainView mainView, String name) {
		this.mainView = mainView;
		this.name = name;
		Log.i("bqt", "【构造MainModule】");
	}
	
	@Provides
	IMainPresenter provideMainPresenter() {
		return new MainPresenter(mainView, name);
	}
}