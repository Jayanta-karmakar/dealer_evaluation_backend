package com.dealer_evaluation_backend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author : jayantakarmakar
 * @mailto : jayantakarmakar998@mail.com
 * @created : 16/03/25, Sunday
 **/

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
class DealerList {
    private List<Dealer> dealers;
}
