Feature: User verify login page

  @test1
  Scenario: UI Verification login page
#    Given user open the browser
    Given User open the demo url
#    When User verify label page
    And User verify Homepage.label_web appears
#    And User verify username field
#    And User verify password field
#    Then User verify button login
    And close browser
