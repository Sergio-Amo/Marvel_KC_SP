# Marvel_KC_SP
### Práctica en kotlin para el módulo Android superpoderes de keepcoding

| :exclamation:  IMPORTANTE :exclamation: |
|-----------------------------------------|
| Para que la app pueda conectarse a la api de marvel es necesario introducir la clave publica y privada en el archivo Authentication, este archivo puede ser encontrado en la ruta **`com.kc.marvel_kc_sp`** la parte donde debes insertar tus claves es esta:<br><br>`private const val publicKey: String = "ENTER_PUBLIC_KEY_HERE"`<br>`private const val privateKey: String = "ENTER_PRIVATE_KEY_HERE"` <br><br>Para evitar que los cambios en el archivo se añadan accidentalmente a git es recomendable marcar el archivo como `skip-worktree` para hacerlo puedes usar el siguiente comando:<br><br>`git update-index --skip-worktree Authentication.kt`<br><br> Si por alguna razón necesitas hacer un commit de cambios realizados en authentication puedes deshacer esto con este comando:<br><br>`git update-index --no-skip-worktree Authentication.kt`<br><br>|
