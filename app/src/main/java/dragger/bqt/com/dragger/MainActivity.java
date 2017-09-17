package dragger.bqt.com.dragger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements IMainView {
	@Inject IMainPresenter mainPresenter;//注意：如果是通过Module中@Provides注解标注的方法来生成对象，这里可以声明为IMainPresenter
	// 否则，必须声明为MainPresenter，因为框架是去查MainPresenter中使用@Inject标注的构造方法，而不是接口中的***
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		DaggerMainComponent.builder()
				.mainModule(new MainModule(this, "包青天"))
				.build()
				.inject(this);
		mainPresenter.login("123");
	}
	
	@Override
	public void showToast(String src) {
		Toast.makeText(this, src, Toast.LENGTH_SHORT).show();
	}
}
