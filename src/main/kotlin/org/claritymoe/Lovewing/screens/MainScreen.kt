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

package org.claritymoe.Lovewing.screens

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.Image
import com.badlogic.gdx.utils.viewport.ScreenViewport
import ktx.actors.centerPosition
import ktx.app.KtxScreen
import org.claritymoe.Lovewing.utils.DiscordUtils

class MainScreen : KtxScreen {
    private val stage = Stage(ScreenViewport())

    init {
        val img = Image(Texture(Gdx.files.absolute("./src/main/resources/img/backgrounds/mainmenu.png")))

        img.width = 1280F
        img.centerPosition(1280F, 720F)

        stage.addActor(img)
    }

    override fun render(delta: Float) {
        DiscordUtils.updatePresence(
                DiscordUtils.presence {
                    details = "Main Menu"
                    state = "Idle"
                    largeImageKey = "logo"
                }
        )

        stage.act()
        stage.draw()
    }
}