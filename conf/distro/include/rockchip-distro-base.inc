require conf/distro/poky.conf

DISTRO = "rockchip-distro-base"
DISTRO_NAME = "Rockchip Distro Base"
SDK_VENDOR = "-rockchipsdk"

# xserver
XSERVER = " \
	xserver-xorg \
	xserver-xorg-utils \
	xserver-xorg-xvfb \
	xserver-xorg-extension-glx \
	xserver-xorg-module-libwfb \
	xserver-xorg-module-exa \
	xf86-video-modesetting \
	xf86-input-evdev \
	xf86-input-mouse \
	xf86-input-keyboard \
	"

DISTRO_FEATURES += " \
    alsa \
    usbgadget \
    usbhost \
    bluez5 \
    x11 \
    opengl \
    systemd \
    "
