package dragger.bqt.com.dragger;

import dagger.Module;
import dagger.Provides;

/**
 * 作者：白乾涛 <a href=[http://www.cnblogs.com/baiqiantao] /><p>
 * 创建时间：2017/9/20 13:51 <p>
 * 描述：
 */
@Module
public class MainPresenterModule {
	@PerMainScope
	@Provides
	IMainModel provideMainModel() {
		return new MainModel();
	}
	
	@PerMainScope
	@Provides
	String provideName() {
		return "白乾涛";
	}
}
