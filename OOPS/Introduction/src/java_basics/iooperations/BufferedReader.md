## Why BufferedReader is not commonly used for beginners:


| Reason                      | Explanation                                                        |
| --------------------------- | ------------------------------------------------------------------ |
| More complex                | Requires manual parsing (e.g., `Integer.parseInt(br.readLine())`). |
| No direct support for types | Only reads strings; you must convert them to `int`, `double`, etc. |
| Needs exception handling    | Must handle `IOException`, adding extra code (try-catch block).    |
| Scanner is easier           | Scanner directly supports multiple data types (int, double, etc.)  |

## When to prefer BufferedReader:
- When reading large amounts of input (e.g., competitive programming).
- When performance matters more than simplicity.