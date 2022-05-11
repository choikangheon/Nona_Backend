package letsnona.nonabackend.domain.review.service;

import letsnona.nonabackend.domain.product.dto.read.ProductReadResDTO;
import letsnona.nonabackend.domain.review.dto.ReviewAddRequestDTO;
import letsnona.nonabackend.domain.review.dto.ReviewUpdateRequestDTO;
import letsnona.nonabackend.domain.review.entity.Review;
import letsnona.nonabackend.domain.review.enums.TradeState;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

public interface ReviewService {
    @Transactional
    Review saveReview(ReviewAddRequestDTO requestDTO);

    @Transactional
    TradeState updateReviewState(long reviewIndex, String tradeState);

    @Transactional
    boolean isReviewOwner(Review review);

    @Transactional
    Review updateReview(long reviewIndex, ReviewUpdateRequestDTO dto);

    Page<ProductReadResDTO> getProductReviews(long productId, Pageable pageable);
}
