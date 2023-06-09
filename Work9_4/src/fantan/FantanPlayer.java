package fantan;

import trump.Card;
import trump.Master;
import trump.Player;
import trump.Rule;
import trump.Table;

/*
 *  クラス名 :FantanPlayer
 *  概要     :七並べのプレイヤーを表すクラス
 *  作成者   :山川勇輝
 *  作成日   :2023.06.08
 */
public class FantanPlayer extends Player{
	/** パスした回数 */
	private int pass_;
	
	/*
	 * コンストラクタ
	 * 概要  ：名前、進行役、テーブルルールを設定
	 * 引数  ：name　名前
	 *         master　進行役
	 *         table　テーブル
	 *         rule　ルール
	 * 戻り値：なし
	 * 作成者：山川勇輝
	 * 作成日：2023.06.08
	 */
	public FantanPlayer(String name, Master master, Table table, Rule rule) {
		// スーパークラスのコンストラクタを呼び出す
		super(name, master, table, rule);
	}
	
	/*
	 * 関数名           :receiveCard
	 * メソッドの説明   :カードを配る
	 * パラメータの説明 :card　受け取ったカード
	 * 返り値           :なし
	 * 作成者           :山川勇輝
	 * 作成日           :2023.06.08
	 */
	public void receiveCard(Card card) {
		// Work9-4 ---------①
		// 受け取ったカードの数字が7なら
		if(card.getNumber() == 7) {
			// Card型の配列を宣言
			Card[] receivedCard = {card};
			// カードを置いた人物を宣言する
			System.out.print(this + ":");
			// そのカードをテーブルに置く
			table_.putCard(receivedCard);
		// もし受け取ったカードが7以外なら
		} else {
			// 受け取ったカードを手札に加える
			myHand_.addCard(card);
		}
	}
	
	/*
	 * 関数名           :play
	 * メソッドの説明   :順番を指名する
	 * パラメータの説明 :nextPlayer　次のプレイヤー
	 * 返り値           :なし
	 * 作成者           :山川勇輝
	 * 作成日           :2023.06.08
	 */
	public void play(Player nextPlayer) {
		// Work9-4 ---------②
		// 手札を表示する
		System.out.println(" " + myHand_);
		
		// テーブルに置くカードを格納する配列
		Card[] candidateCard = null;
		// findCandidateを呼び出しテーブルに置けるカードがあるか調べ配列に格納する
		candidateCard = rule_.findCandidate(myHand_, table_);
		
		// もしテーブルに置けるカードがあるなら
		if(candidateCard != null) {
			// カードをテーブルに並べる
			table_.putCard(candidateCard);
			// テーブルの様子を表示する
			System.out.println("\n" + table_);
			// 所持しているカード枚数を数える
			int numberOfCard = myHand_.getNumberOfCards();
			// 所持カードが0枚になったら
			if(numberOfCard == 0) {
				// 上がりを宣言する
				master_.declareWin(this);
			}
		// もしテーブルに置けるカードがないなら
		} else {
			// パス回数を一回増やす
			pass_++;
			// パスを宣言する
			((FantanMaster)master_).pass(this);
			// もしパス回数が制限回数を超えていたらすべてのカードをテーブルに置く
			if(pass_ > FantanMaster.PASS_LIMIT) {
				// 所持しているカード枚数を数える
				int numberOfCard = myHand_.getNumberOfCards();
				// すべてのカードを順に格納する配列（要素数は1）とする
				Card[] putTableCard = new Card[1];
				// カードの枚数分だけ繰り返す
				for(int countCard = 0; countCard < numberOfCard; countCard++) {
					// putTableCardにカードを格納していく
					putTableCard[0] = myHand_.pickCard(0);
					// カードをテーブルに置く
					table_.putCard(putTableCard);
				}
				// テーブルの様子を表示する
				System.out.println("\n" + table_);
			}
		}
	}
	
	
	/*
	 * 関数名           :getPass
	 * メソッドの説明   :パス回数を数える
	 * パラメータの説明 :なし
	 * 返り値           :パスした回数
	 * 作成者           :山川勇輝
	 * 作成日           :2023.06.08
	 */
	public int getPass() {
		// パス回数を返却する
		return pass_;
	}
}
