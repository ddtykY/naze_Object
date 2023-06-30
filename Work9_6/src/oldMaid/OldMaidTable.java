package oldMaid;

import java.util.ArrayList;

import trump.Card;
import trump.Table;

/*
 *  クラス名 :OldMaidTable
 *  概要     :ババ抜きテーブルクラス
 *  作成者   :山川勇輝
 *  作成日   :2023.06.09
 */
public class OldMaidTable implements Table {
	/** カードを並べるテーブルを表すリスト */
	private ArrayList<Card> tableCards = new ArrayList<Card>();
	
	/*
	 * 関数名           :putCard
	 * メソッドの説明   :カードを置く.
	 * パラメータの説明 :card　カード
	 * 返り値           :なし
	 * 作成者           :山川勇輝
	 * 作成日           :2023.06.09
	 */
	public void putCard(Card[] card) {
		// cardの枚数を取得する
		int numberOfCards = card.length;
		
		// cardの枚数分繰り返す
		for(int countCard = 0; countCard < numberOfCards; countCard++) {
			// 捨てるカードを伝える
			System.out.print(card[countCard] + " ");
			// tableCardに配置する
			tableCards.add(card[countCard]);
		}
		// 捨てたことを伝える
		System.out.println("を捨てました");
	}
	
	/*
	 * 関数名           :getCards
	 * メソッドの説明   :カードを見る
	 * パラメータの説明 :なし
	 * 返り値           :テーブルに置かれたカードを表す配列
	 * 作成者           :山川勇輝
	 * 作成日           :2023.06.09
	 */
	public Card[][] getCards(){
		// tableCardsと同じものを作る
		// 2次元配列を生成する
		Card[][] copyCards = new Card[Card.SUIT_NUM][Card.CARD_NUM];
		// 捨てられているカードの枚数を取得する
		int numberOfDropped = tableCards.size();
		// カードの枚数分繰り返す
		for(int countCard = 0; countCard < numberOfDropped; countCard++) {
			// カードを取得する
			Card tableCard = tableCards.get(countCard);
			// カードの数字を取得する
			int cardNumber = tableCard.getNumber();
			// カードのスートを取得する
			int cardSuit = tableCard.getSuit();
			// 配列に格納する
			copyCards[cardSuit - 1][cardNumber - 1] = tableCard;
		}
		// テーブルに置かれたカードを返却する
		return copyCards;
	}
	
	/*
	 * 関数名           :toString
	 * メソッドの説明   :テーブルを文字列で表現する
	 * パラメータの説明 :なし
	 * 返り値           :テーブルの文字列表現
	 * 作成者           :山川勇輝
	 * 作成日           :2023.06.09
	 */
	public String toString() {
		// StringBufferクラスのインスタンスを生成する
		StringBuffer stringTable = new StringBuffer();
		
		// 捨てられているカードの枚数を取得する
		int numberOfDropped = tableCards.size();
		// カードの枚数分繰り返す
		for(int countCard = 0; countCard < numberOfDropped; countCard++) {
			// 捨てられているカードを文字列に追加する
			stringTable.append(tableCards.get(countCard) + " ");
		}
		// 文字列を返却する
		return stringTable.toString();
	}
}
