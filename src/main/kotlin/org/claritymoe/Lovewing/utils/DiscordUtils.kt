/*
 *    Copyright 2018 ClarityMoe
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package org.claritymoe.Lovewing.utils

import club.minnced.discord.rpc.DiscordEventHandlers
import club.minnced.discord.rpc.DiscordRPC
import club.minnced.discord.rpc.DiscordRichPresence

enum class DiscordReply(val reply: Int) {
    IGNORE(DiscordRPC.DISCORD_REPLY_IGNORE),
    NO(DiscordRPC.DISCORD_REPLY_NO),
    YES(DiscordRPC.DISCORD_REPLY_YES)
}

object DiscordUtils {
    private val discordInstance = DiscordRPC.INSTANCE

    fun init(id: String) {
        discordInstance.Discord_Initialize(
                id,
                object : DiscordEventHandlers() {},
                true,
                null
        )
    }

    fun updatePresence(presence: DiscordRichPresence) = discordInstance.Discord_UpdatePresence(presence)

    fun shutdown() = discordInstance.Discord_Shutdown()

    fun presence(block: DiscordRichPresence.() -> Unit) = DiscordRichPresence().apply(block)

    fun reply(userId: String, reply: DiscordReply) = discordInstance.Discord_Respond(userId, reply.reply)
}