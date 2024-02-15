# Marvel_KC_SP
### Práctica en kotlin para el módulo Android superpoderes de keepcoding

| :exclamation:  IMPORTANTE :exclamation: |
|-----------------------------------------|
| Para que la app pueda conectarse a la api de marvel es necesario introducir la clave publica y privada en el archivo Authentication, este archivo puede ser encontrado en la ruta **`com.kc.marvel_kc_sp`** la parte donde debes insertar tus claves es esta:<br><br>`private const val publicKey: String = "ENTER_PUBLIC_KEY_HERE"`<br>`private const val privateKey: String = "ENTER_PRIVATE_KEY_HERE"` <br><br>Para evitar que los cambios del archivo se añadan a git el archivo está marcado como work-tree y por lo tanto no deberías poder hacer commits de ninguno de sus cambios, si por alguna razón necesitas hacerlo puedes volver a permitir a git seguir el archivo utilizando el siguiente comando:<br><br>`git update-index --no-skip-worktree Authentication.kt`<br><br> No olvides volver a usar el comando <br><br>`git update-index --skip-worktree Authentication.kt`<br><br> una vez hayas terminado.|
