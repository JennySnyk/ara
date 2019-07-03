/******************************************************************************
 * Copyright (C) 2019 by the ARA Contributors                                 *
 *                                                                            *
 * Licensed under the Apache License, Version 2.0 (the "License");            *
 * you may not use this file except in compliance with the License.           *
 * You may obtain a copy of the License at                                    *
 *                                                                            *
 * 	 http://www.apache.org/licenses/LICENSE-2.0                               *
 *                                                                            *
 * Unless required by applicable law or agreed to in writing, software        *
 * distributed under the License is distributed on an "AS IS" BASIS,          *
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.   *
 * See the License for the specific language governing permissions and        *
 * limitations under the License.                                             *
 *                                                                            *
 ******************************************************************************/

package com.decathlon.ara.coverage;

import com.decathlon.ara.domain.Functionality;
import com.decathlon.ara.domain.enumeration.CoverageLevel;
import com.decathlon.ara.service.dto.coverage.AxisPointDTO;
import java.util.Arrays;
import java.util.stream.Stream;
import org.springframework.stereotype.Service;

@Service
public class CoverageAxisGenerator implements AxisGenerator {

    @Override
    public String getCode() {
        return "coverage";
    }

    @Override
    public String getName() {
        return "Coverage level";
    }

    @Override
    public Stream<AxisPointDTO> getPoints(long projectId) {
        return Arrays.stream(CoverageLevel.values())
                .map(coverageLevel -> new AxisPointDTO(coverageLevel.name(), coverageLevel.getLabel(), coverageLevel.getTooltip()));
    }

    @Override
    public String[] getValuePoints(Functionality functionality) {
        return new String[] { functionality.getCoverageLevel().name() };
    }

}
