import QtQuick 2.9
import QtWebView 1.1
import QtQuick.Controls 2.2
import QtQuick.Layouts 1.3
import "../../view_models"

BabePopup
{
    id: videoPlayback

    property alias webView: webView

    WebView
    {
        id: webView
        anchors.fill: parent
        onLoadingChanged: {
            if (loadRequest.errorString)
                console.error(loadRequest.errorString);
        }
    }
}