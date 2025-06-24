#include <iostream>
#include <vector>
#include <sstream>
#include <string>

void solve() {
	int n;
	std::string ans;
	int ways[3][2] = { {1, 3}, {6, 8}, {2, 5} };
	bool flag = false;
	for (int i = 0; i < 3; i++) {
		std::cin >> n;
		std::cin.ignore();
		if (ways[i][0] == n || ways[i][1] == n) {
			continue;
		}
		flag = true;
		break;
	}

	if (flag) {
		ans = "EI";
	}
	else {
		ans = "JAH";
	}


	std::cout << ans;
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}