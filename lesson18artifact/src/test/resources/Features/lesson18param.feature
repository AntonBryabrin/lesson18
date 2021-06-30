Feature: Search in search system

  Scenario Outline: check result of search request
    Given In system "<searchSystem>" we have results for request "<request>"
    When Search in "<searchSystem>" by request "<request>"
    Then Result with request "<request>" is presented on the page
    Examples:
      | searchSystem | request |
      | https://ya.ru | Яндекс |
      | https://ya.ru | YouTube |


  Scenario Outline: Check success name submitting
    Given on the page "<formpage>" we have registration form
    When we enter "<userName>"
    Then submitted "<userName>" is present on the page
    Examples:
      | formpage | userName |
      | https://demoqa.com/text-box | John |