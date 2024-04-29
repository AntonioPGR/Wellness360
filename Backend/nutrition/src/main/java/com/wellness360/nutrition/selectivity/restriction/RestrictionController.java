package com.wellness360.nutrition.selectivity.restriction;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.wellness360.nutrition.selectivity.SelectivityController;


@RestController
@RequestMapping("${path.restriction}")
public class RestrictionController extends SelectivityController<RestrictionEntity>{}
