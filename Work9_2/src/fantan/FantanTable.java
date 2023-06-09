package fantan;

import trump.Card;
import trump.Table;

/*
 *  クラス名 :FantanTable
 *  概要     :七並べのテーブルを表すクラス
 *  作成者   :山川勇輝
 *  作成日   :2023.06.08
 */
public class FantanTable implements Table {
	/** カードを並べるテーブルを表す2次元配列 */
	private Card[][] table_ = new Card[Card.SUIT_NUM][Card.CARD_NUM];
	
	/*
	 * 関数名           :putCard
	 * メソッドの説明   :カードを置く.
	 * パラメータの説明 :card カード
	 * 返り値           :なし
	 * 作成者           :山川勇輝
	 * 作成日           :2023.06.08
	 */
	public void putCard(Card[] card) {
		// Work9-2 … ①
		// cardは配列だが、七並べにおいて置かれるカードは1枚なため、すべてcard[0]を扱う
		// 置かれるカードのスートを調べる
		int cardSuit = card[0].getSuit();
		
		// 置かれるカードの数字を調べる
		int cardNumber = card[0].getNumber();
		
		// テーブルの指定の位置にカードを置く
		table_[cardSuit-1][cardNumber-1] = card[0];

		// カードを並べることを伝える
		System.out.println(" " + table_[cardSuit-1][cardNumber-1] + " を置きました");
	}
	
	/*
	 * 関数名           :getCards
	 * メソッドの説明   :カードを見る
	 * パラメータの説明 :なし
	 * 返り値           :テーブルに置かれたカードを表す配列
	 * 作成者           :山川勇輝
	 * 作成日           :2023.06.08
	 */
	public Card[][] getCards(){
		// Work9-2 … ②
		// テーブルに置かれたカードを返却する
		return table_;
	}
	
	/*
	 * 関数名           :toString
	 * メソッドの説明   :テーブルを文字列で表現する
	 * パラメータの説明 :なし
	 * 返り値           :テーブルの文字列表現
	 * 作成者           :山川勇輝
	 * 作成日           :2023.06.08
	 */
	public String toString() {
		// Work9-2 … ③
		// StringBufferクラスのインスタンスを生成
		StringBuffer stringTable = new StringBuffer();
		
		// カードのスートの種類分繰り返す
		for(int countSuit = 0; countSuit < Card.SUIT_NUM; countSuit++) {
			// カードの値の種類分繰り返す
			for(int countNumber = 0; countNumber < Card.CARD_NUM; countNumber++) {
				// もし[countSuit][countNumber]の位置にカードがなければ
				if(table_[countSuit][countNumber] == null) {
					// 文字列に..を追加する
					stringTable.append("..");
				// もしカードが置かれていれば
				} else {
					// 文字列にカードを表す文字列を追加する
					stringTable.append(table_[countSuit][countNumber]);
				}
				// 一つのトランプを表示するごとにスペースを表示して区切るようにする
				stringTable.append(" ");
			}
			// 一種類のスートについて並べるごとに改行するようにする
			stringTable.append("\n");
		}
		
		// 文字列を返却する
		return stringTable.toString();
	}
}
