package dragger.bqt.com.dragger;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {
	private IMainView mainView;
	
	public MainModule(IMainView mainView) {
		this.mainView = mainView;
	}
	
	@PerMainScope
	@Provides
	IMainPresenter provideMainPresenter() {
		return new MainPresenter(mainView);
	}
}