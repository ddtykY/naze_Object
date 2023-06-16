package work2_2;

/*
 *  クラス名 :SimpleJanken
 *  概要     :Work2_2のオブジェクト指向を使用しないジャンケンクラス
 *  作成者   :山川勇輝
 *  作成日   :2023.06.05
 */
public class SimpleJanken {
	// ジャンケンの手を表す定数
	// グー
	public static final int STONE = 0;
	// チョキ
	public static final int SCISSORS = 1;
	// パー
	public static final int PAPER = 2;

	// ■■■■■■■■■■■■■■■■■
	//   プログラムのスタートはここから
	// ■■■■■■■■■■■■■■■■■
	/*
	 * 関数名           :main
	 * メソッドの説明   :プレイヤー二人で3回勝負のジャンケンを行う
	 * パラメータの説明 :なし
	 * 返り値           :なし
	 * 作成者           :山川勇輝
	 * 作成日           :2023.06.05
	 */
	public static void main(String[] args) {
		// 乱数を格納するための変数
		double randomNum = 0;

		// ■■■■■■■■■■■■■■■■■■■
		//  ①プログラムが開始したことを表示する
		// ■■■■■■■■■■■■■■■■■■■
		// プログラム開始のメッセージを表示する
		System.out.println("【ジャンケン開始】\n");

		// プレイヤー1の勝ち数
		int player1WinCount = 0;

		// プレイヤー2の勝ち数
		int player2WinCount = 0;

		// ジャンケンを3回実施する
		// ■■■■■■■■■■■■■■
		//  ⑥勝負した回数を加算する
		//  ⑦3回勝負が終わったか?
		// ■■■■■■■■■■■■■■
		// 3回繰り返す
		for(int cnt = 0; cnt < 3; cnt++) {
			// ■■■■■■■■■■■■■■■■■
			//  ②プレイヤー1が何を出すか決める
			// ■■■■■■■■■■■■■■■■■
			// プレイヤー1の手の形を格納する変数
			int player1Hand = 0;

			// 0以上3未満の少数として乱数を得る
			randomNum = Math.random() * 3;
			// もし"randomNum"が1未満なら
			if(randomNum < 1) {
				// プレイヤー1の手をグーとする
				player1Hand = STONE;
				// プレイヤー1の手を表示する
				System.out.print("グー");
			// もし"randomNum"が1以上2未満なら
			} else if(randomNum < 2) {
				// プレイヤー1の手をチョキとする
				player1Hand = SCISSORS;
				// プレイヤー1の手を表示する
				System.out.print("チョキ");
			// もし"randomNum"が2以上3未満なら
			} else if (randomNum < 3) {
				// プレイヤー1の手をパーとする
				player1Hand = PAPER;
				// プレイヤー1の手を表示する
				System.out.print("パー");
			}

			// vs.を表示する
			System.out.print(" vs. ");

			// ■■■■■■■■■■■■■■■■■
			//  ③プレイヤー2が何を出すか決める
			// ■■■■■■■■■■■■■■■■■
			// プレイヤー2の手の形を格納する変数
			int player2Hand = 0;

			// 0以上3未満の少数として乱数を得る
			randomNum = Math.random() * 3;
			// もし"randomNum"が1未満なら
			if(randomNum < 1) {
				// プレイヤー2の手をグーとする
				player2Hand = STONE;
				// プレイヤー2の手を表示する
				System.out.print("グー");
			// もし"randomNum"が1以上2未満なら
			} else if(randomNum < 2) {
				// プレイヤー2の手をチョキとする
				player2Hand = SCISSORS;
				// プレイヤー2の手を表示する
				System.out.print("チョキ");
			// もし"randomNum"が2以上3未満なら
			} else if (randomNum < 3) {
				// プレイヤー2の手をパーとする
				player2Hand = PAPER;
				// プレイヤー2の手を表示する
				System.out.print("パー");
			}


			// ■■■■■■■■■■■■■■■■■■■■
			//  ④どちらが勝ちか判定し、結果を表示する
			// ■■■■■■■■■■■■■■■■■■■■
			// プレイヤー1が勝つ場合
			if (   (player1Hand == STONE     && player2Hand == SCISSORS)
					|| (player1Hand == SCISSORS  && player2Hand == PAPER)
					|| (player1Hand == PAPER     && player2Hand == STONE)  )
			{
				// ■■■■■■■■■■■■■■■■■■■
				//  ⑤プレイヤー1の勝った回数を加算する
				// ■■■■■■■■■■■■■■■■■■■
				// "player1WinCount"をインクリメント
				player1WinCount++;

				// ジャンケンの結果を表示する
				System.out.println("\nプレイヤー1が勝ちました!\n");
			// プレイヤー2が勝つ場合
			} else if (   (player1Hand == STONE     && player2Hand == PAPER)
					|| (player1Hand == SCISSORS  && player2Hand == STONE)
					|| (player1Hand == PAPER     && player2Hand == SCISSORS)  )
			{
				// ■■■■■■■■■■■■■■■■■■■
				//  ⑥プレイヤー2の勝った回数を加算する
				// ■■■■■■■■■■■■■■■■■■■
				// "player2WinCount"をインクリメント
				player2WinCount++;
				
				// ジャンケンの結果を表示する
				System.out.println("\nプレイヤー2が勝ちました!\n");
			// 引き分けの場合
			} else {
				// ジャンケンの結果を表示する
				System.out.println("\n引き分けです!\n");
			}
		}
		
		// ■■■■■■■■■■■■■■■■■■■■
		//  ⑧最終的な勝者を判定し、画面に表示する
		// ■■■■■■■■■■■■■■■■■■■■
		// ジャンケンが終了する旨を表示する
		System.out.println("【ジャンケン終了】\n");
		
		// プレイヤー1の勝ち数が多いとき
		if(player1WinCount > player2WinCount) {
			// プレイヤー1の勝ちを表示する
			System.out.println(player1WinCount + "対" + player2WinCount + "でプレイヤー1の勝ちです!\n");
		// プレイヤー2の勝ち数が多いとき
		} else if(player1WinCount < player2WinCount) {
			// プレイヤー2の勝ちを表示する
			System.out.println(player1WinCount + "対" + player2WinCount + "でプレイヤー2の勝ちです!\n");
		// プレイヤー1とプレイヤー2の勝ち数が同じとき
		} else if(player1WinCount == player2WinCount){
			// プレイヤー2の勝ちを表示する
			System.out.println(player1WinCount + "対" + player2WinCount + "で引き分けです!\n");
		}
		
	}

}

