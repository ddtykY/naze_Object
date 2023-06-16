package work4_1;

/*
 *  クラス名 :Yamada
 *  概要     :Work3_2で作成したジャンケンのプレイヤーを表すクラス(山田さん専用)
 *  作成者   :山川勇輝
 *  作成日   :2023.06.05
 */
public class Yamada {
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

	/*
	 * コンストラクタ
	 * 概要：プレーヤークラスのコンストラクタ
	 * 引数：name　名前
	 * 戻り値：なし
	 * 作成者：山川勇輝
	 * 作成日：2023.06.05
	 */
	public Yamada(String name) {
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

		// 乱数を格納するための変数
		double randomNum = Math.random() * 3;
		// もし"randomNum"が1未満なら
		if(randomNum < 1) {
			// プレイヤーの手をグーとする
			playerHand = STONE;
		// もし"randomNum"が1以上2未満なら
		} else if(randomNum < 2) {
			// プレイヤーの手をチョキとする
			playerHand = SCISSORS;
		// もし"randomNum"が2以上3未満なら
		} else if (randomNum < 3) {
			// プレイヤーの手をパーとする
			playerHand = PAPER;
		}
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
}
