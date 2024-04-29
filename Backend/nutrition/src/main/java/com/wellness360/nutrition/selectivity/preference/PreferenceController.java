package com.wellness360.nutrition.selectivity.preference;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.wellness360.nutrition.selectivity.SelectivityController;


@RestController
@RequestMapping("${path.preference}")
public class PreferenceController extends SelectivityController<PreferenceEntity>{}
