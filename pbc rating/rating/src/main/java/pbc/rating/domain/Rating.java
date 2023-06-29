package pbc.rating.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import pbc.rating.RatingApplication;

@Entity
@Table(name = "Rating_table")
@Data
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String topicId;

    private Integer averageRate;

    private Long sumOfRatings;

    private Long countOfRatings;

    @PostPersist
    public void onPostPersist() {}

    public static RatingRepository repository() {
        RatingRepository ratingRepository = RatingApplication.applicationContext.getBean(
            RatingRepository.class
        );
        return ratingRepository;
    }

    public void rate(RateCommand rateCommand) {
        //implement business logic here:

        RatingRated ratingRated = new RatingRated(this);
        ratingRated.publishAfterCommit();
    }
}
