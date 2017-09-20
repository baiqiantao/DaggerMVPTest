package dragger.bqt.com.dragger;

import android.util.Log;

import javax.inject.Inject;

public class MainPresenter implements IMainPresenter {
	private IMainView mainView;
	@Inject String name;
	@Inject IMainModel mainModel;
	
	public MainPresenter(IMainView mainView) {
		this.mainView = mainView;
		mainView.getMainComponent().injectToMainPresenter(this);
	}
	
	@Override
	public void login(String password) {
		String info = mainModel.login(name, password);
		if (mainView != null) mainView.showToast(info);
		Log.i("bqt", info);
	}
}