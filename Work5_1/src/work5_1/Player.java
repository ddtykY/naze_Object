package work5_1;

/*
 *  クラス名 :Player
 *  概要     :Work3_2で作成したジャンケンのプレイヤーを表すクラス
 *  作成者   :山川勇輝
 *  作成日   :2023.06.05
 */
public class Player {
	// ジャンケンの手を表す定数
	// グー
	public static final int STONE = 0;
	// チョキ
	public static final int SCISSORS = 1;
	// パー
	public static final int PAPER = 2;
	
	
	//------------------------
	// プレイヤークラスの属性
	//------------------------
	/** プレイヤーの名前 */
	private String name_;
	
	/** プレイヤーの勝った回数 */
	private int winCount_ = 0;
	
	
	/** プレイヤーの戦略 */ // Work5-1
	private Tactics playerTactics_;
	
	/*
	 * コンストラクタ
	 * 概要：プレーヤークラスのコンストラクタ
	 * 引数：name　名前
	 * 戻り値：なし
	 * 作成者：山川勇輝
	 * 作成日：2023.06.05
	 */
	public Player(String name) {
		// インスタンスの属性"name_"に引数として与えられた"name"を代入する
		name_ = name;
	}

	//------------------------
	// プレイヤークラスの操作
	//------------------------
	/*
	 * 関数名           :showHand
	 * メソッドの説明   :ジャンケンの手を出す
	 * パラメータの説明 :なし
	 * 返り値           :plyerHand　ジャンケンの手
	 * 作成者           :山川勇輝
	 * 作成日           :2023.06.05
	 */
	public int showHand() {
		// ジャンケンの手
		int playerHand = 0;
		
		// Work5-1
		// ジャンケンの手を戦略に基づいて決める
		playerHand = playerTactics_.readTactics();
		
		// ジャンケンの手を返却する
		return playerHand;
	}

	/*
	 * 関数名           :notifyResult
	 * メソッドの説明   :審判から勝敗を聞く
	 * パラメータの説明 :result　true:勝ち、false:負け
	 * 返り値           :なし
	 * 作成者           :山川勇輝
	 * 作成日           :2023.06.05
	 */
	public void notifyResult(boolean result) {
		// もし"result"がtrueなら
		if(result == true) {
			// "winCount_"をインクリメント
			winCount_++;
		}
	}
	
	/*
	 * 関数名           :getWinCount
	 * メソッドの説明   :自分の勝った回数を答える
	 * パラメータの説明 :なし
	 * 返り値           :winCount_　勝った回数
	 * 作成者           :山川勇輝
	 * 作成日           :2023.06.05
	 */
	public int getWinCount() {
		// "winCount_"を返却する
		return winCount_;
	}
	
	/*
	 * 関数名           :getName
	 * メソッドの説明   :自分の名前を答える
	 * パラメータの説明 :なし
	 * 返り値           :name_　名前
	 * 作成者           :山川勇輝
	 * 作成日           :2023.06.05
	 */
	public String getName() {
		// "name_"を返却する
		return name_;
	}
	
	// Work5-1
	/*
	 * 関数名           :setPlayerTactics
	 * メソッドの説明   :戦略を渡す
	 * パラメータの説明 :playerTactics　戦略
	 * 返り値           :なし
	 * 作成者           :山川勇輝
	 * 作成日           :2023.06.05
	 */
	public void setPlayerTactics(Tactics playerTactics) {
		// プレイヤーの戦略を決める
		playerTactics_ = playerTactics;
	}
	
	
	
}
