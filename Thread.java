//このプログラムは,０から10 までの数値を出力するスレッドを並行動作させます
//使い方java Threadtest

//ライブラリの利用

import java.io.InputStream;
import java.io.OutputStream;

//Threadtestクラス
//Threadtestクラスは,スレッドの作成と実行を管理します
public class T0 {
	// mainメソッド
	public static void main(String[] arg){
		try {
			
			// ここでは，オブジェクトSystem.in/System.out をメソッドPseudoStreamConnector により，
			
			StreamConnector no3 = new StreamConnector(); 
			
			// 入出力のストリームをセット
			no3.PseudoStreamConnector(System.in,System.out);
			
			// スレッドを生成します
			Thread no3_thread = new Thread(no3);

			// スレッドを起動します
			no3_thread.start();
		}
		catch(Exception e){
			System.err.print(e);
			System.exit(1);
		}
	}
}

class StreamConnector implements Runnable {
	
	InputStream src = null; // 入力用のストリーム（何が入るかは未定）
	OutputStream dist = null; // 出力用のストリーム（何が入るかは未定）

	// （擬似）コンストラクタ入出力ストリームを受け取ります
	// ここではただの in ⇒ src と out ⇒ dist にセットするメソッド
	public void PseudoStreamConnector(InputStream in, OutputStream out){
		src = in;
		dist = out;
	}

	
	// 処理の本体
	public void run(){
			byte[] buff = new byte[1024];
			while (true) {
				try {
					int n = src.read(buff);
					if (n > 0)
						dist.write(buff, 0, n);
				}
				catch(Exception e){
					e.printStackTrace();
					System.err.print(e);
					System.exit(1);
				}
			}			
	}
}
