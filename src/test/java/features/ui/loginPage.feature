Feature: User verify login page

  @test1
  Scenario: UI Verification login page
    Given User open the demo url
    And User verify Homepage.label_web appears
    And User verify Homepage.uname_form appears
    And User verify Homepage.password_form appears
    Then User verify Homepage.button_login appears
    And close browser
