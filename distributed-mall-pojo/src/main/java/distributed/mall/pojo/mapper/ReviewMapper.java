package distributed.mall.pojo.mapper;

import distributed.mall.pojo.pojo.Review;

import java.util.List;

/**
 * <b><code>ReviewMapper</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2019/1/25 14:27.
 *
 * @author virvil
 * @since distributed-mall ${PROJECT_VERSION}
 */
public interface ReviewMapper {

    List<Review> getReview(Integer id) throws Exception;

    List<Review> listReviewsBySpuId(Integer spuId) throws Exception;

    List<Review> listReviewsBySkuId(Integer skuId) throws Exception;

    int saveReview(Review review) throws Exception;

    int updReview(Review review) throws Exception;

    int delReview(Integer id) throws Exception;

    int delReviewsBySpuId(Integer spuId) throws Exception;

    int delReviewsBySkuId(Integer skuId) throws Exception;
}
