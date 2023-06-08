package work5_2;

/*
 *  クラス名 :ObjectJanken
 *  概要     :オブジェクト指向によるジャンケンプログラム
 *  作成者   :山川勇輝
 *  作成日   :2023.06.05
 */
public class ObjectJanken {
	/*
	 * 関数名           :main
	 * メソッドの説明   :プレイヤー二人で3回勝負のジャンケンを行う
	 * パラメータの説明 :なし
	 * 返り値           :なし
	 * 作成者           :山川勇輝
	 * 作成日           :2023.06.05
	 */
	public static void main(String args[]) {
		// 審判（斎藤さん）のインスタンス生成
		Judge saito = new Judge();
		
		// プレイヤー1（村田さん）の生成
		Player murata = new Player("村田さん");
		
		// 村田さんに渡す戦略クラスを生成する
		Tactics murataTactics = new CyclicTactics();
		
		// 村田さんに戦略クラスを渡す
		murata.setPlayerTactics(murataTactics);
		
		// プレイヤー2（山田さん）の生成
		Player yamada = new Player("山田さん");
		
		// 村田さんに渡す戦略クラスを生成する
		Tactics yamadaTactics = new AskTactics();

		// 村田さんに戦略クラスを渡す
		yamada.setPlayerTactics(yamadaTactics);
		
		// 村田さんと山田さんをプレイヤーとしてジャンケンを開始する
		saito.startJanken(murata, yamada);
	}

}
