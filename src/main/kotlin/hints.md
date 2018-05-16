### Склеить попарно соседние символы строки
```kotlin
(0 until n - 1)
    .map { "${s[it]}${s[it + 1]}" }
```

### Максимум мапы по значению:
```kotlin
map.entries.maxBy { it.value }?.
```
