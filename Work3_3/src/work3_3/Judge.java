package work3_3;

/*
 *  クラス名 :Judge
 *  概要     :Work3_3のジャンケンの審判を表すクラス
 *  作成者   :山川勇輝
 *  作成日   :2023.06.05
 */
public class Judge {
	/*
	 * 関数名           :startJanken
	 * メソッドの説明   :ジャンケンを開始する
	 * パラメータの説明 :player1　判定対象プレイヤー1
	 *                   player2　判定対象プレイヤー2
	 * 返り値           :なし
	 * 作成者           :山川勇輝
	 * 作成日           :2023.06.05
	 */
	public void startJanken(Player player1, Player player2) {
		// ジャンケンの開始を宣言する
		System.out.println("【ジャンケン開始】\n");
		
		// ジャンケンを3回行う
		for(int cnt = 0; cnt < 3; cnt++) {
			// 何回戦目か表示する
			System.out.println("【" + (cnt + 1) + "回戦目】");
			
			// プレイヤーの手を見て、どちらが勝ちかを判定する
			Player winner = judgeJanken(player1, player2);
			
			// もし"winner"がnullでなければ
			if(winner != null) {
				// 勝者を表示する
				System.out.println(winner.getName() + "が勝ちました!\n");
				
				// 勝ったプレイヤーへ結果を伝える----------------①
				winner.notifyResult(true);
				
			// 引き分けの場合	
			} else {
				// 引き分けであることを表示する
				System.out.println("引き分けです!\n");
			}
		}
		
		// ジャンケンの終了を宣言する
		System.out.println("【ジャンケン終了】\n");
		
		// 最終的な勝者を判定する
		Player finalWinner = judgeFinalWinner(player1, player2);
		
		// 結果の表示
		System.out.print(player1.getWinCount() + "対" + player2.getWinCount() + "で");
		
		// もし"finalWinner"がnullでなければ
		if(finalWinner != null) {
			// 勝者を表示する
			System.out.println(finalWinner.getName() + "の勝ちです!\n");
		// 引き分けの場合
		} else {
			// 引き分けであることを表示する
			System.out.print("引き分けです!\n");
		}
	}
	
	/*
	 * 関数名           :judgeJanken
	 * メソッドの説明   :プレイヤーの手を見て、どちらが勝ちかを判定する
	 * パラメータの説明 :player1　判定対象プレイヤー1
	 *                   player2　判定対象プレイヤー2
	 * 返り値           :winner　勝ったプレーヤー。引き分けの場合はnullを返す
	 * 作成者           :山川勇輝
	 * 作成日           :2023.06.05
	 */
	private Player judgeJanken(Player player1, Player player2) {
		// Player型の勝者を表すインスタンスをnullで初期化する
		Player winner = null;
		
		// プレーヤー1の手を出す-------------------②
		int player1hand = player1.showHand();
		// プレイヤー2の手を出す-------------------③
		int player2hand = player2.showHand();
		
		
		// プレイヤー1の手を表示する
		printHand(player1hand);
		// vs.を表示する
		System.out.print(" vs. ");
		// プレイヤー2の手を表示する
		printHand(player2hand);
		// 改行する
		System.out.print("\n");
		
		
		//プレイヤー1が勝つ場合
		if (   (player1hand == Player.STONE     && player2hand == Player.SCISSORS)
			|| (player1hand == Player.SCISSORS  && player2hand == Player.PAPER)
			|| (player1hand == Player.PAPER     && player2hand == Player.STONE)  )
		{
			// "winner"をプレイヤー1とする
			winner = player1;
		// プレイヤー2が勝つ場合
		} else if( (player1hand == Player.STONE     && player2hand == Player.PAPER)
				|| (player1hand == Player.SCISSORS  && player2hand == Player.STONE)
				|| (player1hand == Player.PAPER     && player2hand == Player.SCISSORS)  )
		{
			// "winner"をプレイヤー2とする
			winner = player2;
		}
		
		// "winner"を返却する。引き分けの場合はnullを返却する
		return winner;
	}
	
	/*
	 * 関数名           :judgeFinalWinner
	 * メソッドの説明   :最終的な勝者を判定
	 * パラメータの説明 :player1　判定対象プレイヤー1
	 *                   player2　判定対象プレイヤー2
	 * 返り値           :winner　勝ったプレーヤー。引き分けの場合はnullを返す
	 * 作成者           :山川勇輝
	 * 作成日           :2023.06.05
	 */
	private Player judgeFinalWinner(Player player1, Player player2) {
		// Player型の勝者を表すインスタンスをnullで初期化する
		Player winner = null;
		
		// player1から勝ち数を聞く-------------------④
		int player1WinCount = player1.getWinCount();
		// player2から勝ち数を聞く-------------------⑤
		int player2WinCount = player2.getWinCount();
		
		
		// もしプレイヤー1の勝ち数のほうが多ければ
		if(player1WinCount > player2WinCount) {
			// プレーヤー1の勝ち
			winner = player1;
		// もしプレイヤー2の勝ち数のほうが多ければ
		} else if(player1WinCount < player2WinCount) {
			// プレーヤー2の勝ち
			winner = player2;
		}
		
		// "winner"を返却する。引き分けの場合はnullを返却する
		return winner;
	}
	
	/*
	 * 関数名           :printHand
	 * メソッドの説明   :ジャンケンの手を表示する
	 * パラメータの説明 :hand　ジャンケンの手
	 * 返り値           :なし
	 * 作成者           :山川勇輝
	 * 作成日           :2023.06.05
	 */
	private void printHand(int hand) {
		// "hand"の値によって変化させる
		switch(hand) {
		// グーの場合
		case Player.STONE : 
			// グーと表示する
			System.out.print("グー");
			// swicth文を抜け出す
			break;
		// チョキの場合
		case Player.SCISSORS : 
			// チョキと表示する
			System.out.print("チョキ");
			// swicth文を抜け出す
			break;
		// パーの場合
		case Player.PAPER : 
			// パーと表示する
			System.out.print("パー");
			// swicth文を抜け出す
			break;
		// どれにも該当しない場合
		default :
			// switch文を抜け出す
			break;
		}
	}
	
}
