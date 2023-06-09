package oldMaid;

import trump.Card;
import trump.Hand;
import trump.Master;
import trump.Player;
import trump.Rule;
import trump.Table;

/*
 *  クラス名 :OldMaidPlayer
 *  概要     :ババ抜きプレイヤー
 *  作成者   :山川勇輝
 *  作成日   :2023.06.09
 */
public class OldMaidPlayer extends Player {
	
	/*
	 * コンストラクタ
	 * 概要  ：名前、進行役、テーブル、ルールを設定
	 * 引数  ：name　名前
	 *         master　進行役
	 *         table　テーブル
	 *         rule　ルール
	 * 戻り値：なし
	 * 作成者：山川勇輝
	 * 作成日：2023.06.09
	 */
	public OldMaidPlayer(String name, Master master, Table table, Rule rule) {
		// スーパークラスのコンストラクタを呼び出す
		super(name, master, table, rule);
	}
	
	/*
	 * 関数名           :play
	 * メソッドの説明   :順番を指名する
	 * パラメータの説明 :nextPlayer　次のプレイヤー
	 * 返り値           :なし
	 * 作成者           :山川勇輝
	 * 作成日           :2023.06.09
	 */
	public void play(Player nextPlayer) {
		// 次のプレイヤーに手札を出してもらう
		Hand nextHand = ((OldMaidPlayer)nextPlayer).showHand();
		// 次のプレイヤーの手札から1枚引く.
		// この時、次のプレイヤーは手札を出す前にシャッフルしているため引くのは1枚目とする
		Card pickedCard = nextHand.pickCard(0);
		// 引いたカードを表示する
		System.out.println(this + " :" + nextPlayer + "さんから" + pickedCard + " を引きました");
		// 手札にカードを加える
		myHand_.addCard(pickedCard);
		
		// 捨てられるカードがあるか探す
		Card[] candidateCard = rule_.findCandidate(myHand_, table_);
		
		// もしあったら
		if(candidateCard != null) {
			// 人物を表示する
			System.out.print(this + " :");
			// テーブルにカードを捨てる
			table_.putCard(candidateCard);
		}
		
		// 手札の枚数を数える
		int numberOfCard = myHand_.getNumberOfCards();
		// もし0枚なら
		if(numberOfCard == 0) {
			// 上がりを宣言する
			master_.declareWin(this);
		// 手札がまだあるなら
		} else {
			// 現在の手札を表示する
			System.out.println(this + " :残り手札は" + myHand_ + "です");
		}
	}
	
	/*
	 * 関数名           :showHand
	 * メソッドの説明   :手札を出す
	 * パラメータの説明 :なし
	 * 返り値           :手札
	 * 作成者           :山川勇輝
	 * 作成日           :2023.06.09
	 */
	public Hand showHand() {
		// 自分の手札の枚数を取得する
		int numberOfCards = myHand_.getNumberOfCards();
		// この時点で残り一枚の場合上がりになる
		// もし1枚の場合
		if(numberOfCards == 1) {
			// 上がりを宣言する
			master_.declareWin(this);
		}
		// 見せる前にシャッフルする
		myHand_.shuffle();
		
		// 自分の手札を返却する
		return myHand_;
	}
	
}
