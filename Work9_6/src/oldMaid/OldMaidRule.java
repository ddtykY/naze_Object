package oldMaid;

import trump.Card;
import trump.Hand;
import trump.Rule;
import trump.Table;

/*
 *  クラス名 :OldMaidRule
 *  概要     :ババ抜きルールクラス
 *  作成者   :山川勇輝
 *  作成日   :2023.06.09
 */
public class OldMaidRule implements Rule {
	
	/*
	 * 関数名           :findCandidate
	 * メソッドの説明   :テーブルに置けるカードを探す.手札とテーブルから、テーブルに出しうるカードの組み合わせを探す。
	 * パラメータの説明 :hand　手札
	 *                   table　テーブル
	 * 返り値           :見つかったカードの組み合わせ.見つからなかった場合はnullを返す
	 * 作成者           :山川勇輝
	 * 作成日           :2023.06.09
	 */
	public Card[] findCandidate(Hand hand, Table table) {
		// カードの組み合わせを格納する配列をnullで初期化する
		Card[] sameCard = null;
		
		// 手札の枚数を数える
		int numberOfCards = hand.getNumberOfCards();
		// 手札に加わったのが一番新しいカードを取得する
		Card lastCard = hand.lookCard(numberOfCards-1);
		// そのカードの数字を取得する
		int lastCardNumber = lastCard.getNumber();
		
		// 手札の枚数-1だけ繰り返す
		for(int countNumber = 0; countNumber < numberOfCards-1; countNumber++) {
			// 手札のカードを取得
			Card handCard = hand.lookCard(countNumber);
			// 取得したカードの数字を調べる
			int handCardNumber = handCard.getNumber();
			// 最後のカードと等しければ
			if(lastCardNumber == handCardNumber) {
				// sameカードを要素数2の配列とする
				sameCard = new Card[2];
				// 0番目の要素に加わったのが一番新しいカードの参照を渡す
				sameCard[0] = hand.pickCard(numberOfCards-1);
				// 1番目の要素に数字が等しい値の参照を渡す
				sameCard[1] = hand.pickCard(countNumber);
				// ループを抜ける
				break;
			}
		}
		// sameCardを返却する
		return sameCard;
	}

}
