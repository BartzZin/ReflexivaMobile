package com.lucaslara.reflucaslara.bases

class Registros {
    companion object {

        fun createLinks() : ArrayList<Redes>{
            val list = ArrayList<Redes>()
            list.add(
                Redes(
                    nomeRede = "LinkedIn",
                    link = "https://www.linkedin.com/in/lucas-marcelino-000327238/"
                )
            )
            list.add(
                Redes(
                    nomeRede = "Facebook",
                    link = "https://www.facebook.com/lucas.marcelino.7564?locale=pt_BR"
                )
            )
            list.add(
                Redes(
                    nomeRede = "WhatsApp",
                    link = "contate.me/lucasmarcelinolara"
                )
            )
            list.add(
                Redes(
                    nomeRede = "Twitter",
                    link = "https://twitter.com/LucasML16"
                )
            )
            list.add(
                Redes(
                    nomeRede = "Instagram",
                    link = "https://www.instagram.com/lucas_lmarcelino/"
                )
            )
            return list
        }
    }
}