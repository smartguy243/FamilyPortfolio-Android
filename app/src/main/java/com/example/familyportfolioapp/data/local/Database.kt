package com.example.familyportfolioapp.data.local

import com.example.familyportfolioapp.data.model.Member
import java.util.UUID

object Database {

    val members = listOf(
        Member(
            id = UUID.fromString("1ba7b810-9dad-11d1-80b4-00c04fd430c8"),
            firstName = "Guy",
            name = "Mukeba",
            range = "Père"
        ),
        Member(
            id = UUID.fromString("1ba7b811-9dad-11d1-80b4-00c04fd430c8"),
            firstName = "Maguy",
            name = "Ndaya",
            range = "Mère"
        ),
        Member(
            id = UUID.fromString("1ba7b812-9dad-11d1-80b4-00c04fd430c8"),
            firstName = "Doux Salem",
            name = "Kayembe",
            range = "Frère"
        ),
        Member(
            id = UUID.fromString("1ba7b813-9dad-11d1-80b4-00c04fd430c8"),
            firstName = "Detty",
            name = "Kayaya",
            range = "Soeur"
        ),
        Member(
            id = UUID.fromString("1ba7b814-9dad-11d1-80b4-00c04fd430c8"),
            firstName = "Eraste",
            name = "Kadiayi",
            range = "Frère"
        ),
        Member(
            id = UUID.fromString("1ba7b815-9dad-11d1-80b4-00c04fd430c8"),
            firstName = "Eben-Ezer",
            name = "Mukeba",
            range = "Frère"
        ),
        Member(
            id = UUID.fromString("1ba7b816-9dad-11d1-80b4-00c04fd430c8"),
            firstName = "Gracia",
            name = "Ngandu",
            range = "Soeur"
        )
    )
}