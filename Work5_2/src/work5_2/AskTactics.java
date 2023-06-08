package work5_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 *  クラス名 :AskTactics
 *  概要     :標準入力によりジャンケンの手をユーザに聞く戦略クラス
 *  作成者   :山川勇輝
 *  作成日   :2023.06.06
 */
public class AskTactics implements Tactics {
	/*
	 * 関数名           :readTactics
	 * メソッドの説明   :戦略を読み、ジャンケンの手を得る。
	 * パラメータの説明 :なし
	 * 返り値           :ジャンケンの手
	 * 作成者           :山川勇輝
	 * 作成日           :2023.06.06
	 */
	public int readTactics() {
		// BufferedReaderクラスのインスタンスを生成
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 手の入力
		System.out.println("\nジャンケンの手を入力してください");
		// グーの手
		System.out.println("0 : グー");
		// チョキの手
		System.out.println("1 : チョキ");
		// パーの手
		System.out.println("2 : パー\n");
		// 入力を促す
		System.out.print("? ");

		// ジャンケンの手
		int hand = 0;

		// 無限ループ(0～2の値が入力されるまで)
		while (true) {
			// try文で例外処理
			try {
				// 入力文字列を受け取る
				String inputStr = br.readLine();

				// 入力文字列を数値に変換する
				hand = Integer.parseInt(inputStr);

				// 0～2のいずれかが入力されたらループを抜ける
				if(	   hand == Player.STONE
						|| hand == Player.SCISSORS
						|| hand == Player.PAPER) {
					// ループを抜ける
					break;
					// 0～2以外なら
				} else {
					// 入力が正しくない旨を表示する
					System.out.println("入力が正しくありません。再度入力してください。");
					// 入力を促す
					System.out.print("? ");
				}
			}
			// 例外（整数値以外）が入力された場合
			catch (Exception ex) {
				// 入力が正しくない旨を表示する
				System.out.println("入力が正しくありません。再度入力してください。");
				// 入力を促す
				System.out.print("? ");
			}
		}
		// 手を返却する
		return hand;
	}
}


