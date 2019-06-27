package dalibao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created With IntelliJ IDEA.
 * Descriptions:在LeetCode商店中， 有许多在售的物品。
 *
 * 然而，也有一些大礼包，每个大礼包以优惠的价格捆绑销售一组物品。
 *
 * 现给定每个物品的价格，每个大礼包包含物品的清单，以及待购物品清单。请输出确切完成待购清单的最低花费。
 *
 * 每个大礼包的由一个数组中的一组数据描述，最后一个数字代表大礼包的价格，其他数字分别表示内含的其他种类物品
 * 的数量。
 *
 * 任意大礼包可无限次购买。
 *
 * 思想：分为3步：
 *
 *   1. 每种物品都单独购买，需要money1
 *   2. 用大礼包进行替换， 需要money2
 *   3. 取最小值min(money1, money2)
 *
 *   减枝：
 *       1. 当礼包中的物品的数量  >  所需物品的数量， 要进行减枝
 *       2. 为了避免像，礼包1，2 和 礼包2， 1这种情况重复计算两次，可以使用pos来指向当前的位置
 *          允许获取的礼包的索引只能大于等于pos（这种减枝比较隐蔽）
 * User:Mr.Du
 * Date:2019-06-27
 * Time:22:46
 */
public class Main {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return shoppingOffers(price,special, needs, 0);
    }

    private int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int pos){
        int local_min = directParchase(price, needs);
        for(int i = pos; i < special.size() ; i ++){
            List<Integer> tmp = new ArrayList<>();
            List<Integer> offer = special.get(i);
            for(int j = 0 ; j < needs.size(); j ++){
                if(offer.get(j) > needs.get(j)){
                    tmp = null;
                    break;
                }
                tmp.add(needs.get(j) - offer.get(j));
            }
            if(tmp != null){
                local_min = Math.min(local_min, offer.get(offer.size() - 1) +            shoppingOffers(price, special, tmp, i));
            }
        }
        return local_min;
    }

    private int directParchase(List<Integer>price, List<Integer> needs){
        int sum = 0;
        for(int i = 0 ; i < needs.size() ; i ++){
            sum += price.get(i) * needs.get(i);
        }
        return sum;
    }
}
