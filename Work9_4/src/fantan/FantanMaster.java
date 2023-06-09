package fantan;

import trump.Master;

/*
 *  クラス名 :FantanMaster
 *  概要     :七並べの進行役を表すクラス
 *  作成者   :山川勇輝
 *  作成日   :2023.06.08
 */
public class FantanMaster extends Master {
	/** パスできる制限回数 */
	public static final int PASS_LIMIT = 3;
	
	/*
	 * 関数名           :pass
	 * メソッドの説明   :パスを宣言する
	 * パラメータの説明 :player　パスするプレイヤー
	 * 返り値           :なし
	 * 作成者           :山川勇輝
	 * 作成日           :2023.06.08
	 */
	public void pass(FantanPlayer player) {
		// パスを表示
		System.out.println(" " + player + "さんは" + player.getPass() + " 回目のパスをしました!");
		
		// もしパスの制限回数を超えていたら
		if (player.getPass() > PASS_LIMIT) {
			// 負けを表示する
			System.out.println(" " + player + "さんは負けです!");
			// 敗北者を参加プレイヤーから削除する
			deregisterPlayer(player);
		}
	}
}
