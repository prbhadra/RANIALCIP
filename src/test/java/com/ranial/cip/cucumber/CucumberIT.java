package com.ranial.cip.cucumber;

import org.junit.runner.RunWith;

import com.ranial.cip.AbstractCassandraTest;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = "pretty", features = "src/test/features")
public class CucumberIT extends AbstractCassandraTest {

}
