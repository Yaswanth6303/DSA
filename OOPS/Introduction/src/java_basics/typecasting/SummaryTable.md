## Summary

| Conversion Type  | From → To      | Type      | Casting Required | Data Loss Risk?   |
| ---------------- | -------------- | --------- | ---------------- | ----------------- |
| Implicit Casting | `int → double` | Widening  | ❌ No             | ❌ No              |
| Implicit Casting | `char → int`   | Widening  | ❌ No             | ❌ No              |
| Explicit Casting | `double → int` | Narrowing | ✅ Yes            | ✅ Yes (truncates) |
| Explicit Casting | `int → byte`   | Narrowing | ✅ Yes            | ✅ Yes (overflow)  |
