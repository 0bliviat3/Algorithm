#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>
#include <climits>
#include <unordered_map>

void solve() {

	bool flag = false;

    for (int i = 1; i < 6; i++) {
        std::string s;
        std::cin >> s;
        if (s.find("FBI") != std::string::npos) {
            std::cout << i << " ";
			flag = true;
        }
	}

	if (!flag) std::cout << "HE GOT AWAY!" << std::endl;
}

int main() {
    std::ios::sync_with_stdio(false);
    std::cin.tie(nullptr);
    solve();
    return 0;
}