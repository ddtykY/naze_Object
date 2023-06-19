package work5_2;

/*
 *  クラス名 :CyclicTactics
 *  概要     :Tacticsインターフェースを実装した戦略クラス。グー・チョキ・パーを順番に出す
 *  作成者   :山川勇輝
 *  作成日   :2023.06.06
 */
public class CyclicTactics implements Tactics {
	//------------------
	// 戦略クラスの属性
	//------------------
	/** 手を表す変数 */
	private int handTactics = -1;
	
	/*
	 * 関数名           :readTactics
	 * メソッドの説明   :戦略を読み、ジャンケンの手を得る。
	 * パラメータの説明 :なし
	 * 返り値           :ジャンケンの手
	 * 作成者           :山川勇輝
	 * 作成日           :2023.06.06
	 */
	public int readTactics() {
		// もし一つ前がグーなら
		if (handTactics == Player.STONE) {
			// "handTactics"をチョキのものに変える
			handTactics = Player.SCISSORS;
		// もしひとつ前がチョキなら
		} else if(handTactics == Player.SCISSORS) {
			// "handTactics"をパーのものに変える
			handTactics = Player.PAPER;
		// グーでもパーでもないなら
		} else {
			// "handTactics"をグーのものに変える
			handTactics = Player.STONE;
		}
		
		// "handTactics"を返却する
		return handTactics;
	}
	
	
}
